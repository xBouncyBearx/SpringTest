package com.example.springtest.Service;

import com.example.springtest.DTO.GetDetailsResponse;
import com.example.springtest.DTO.LoginRequest;
import com.example.springtest.DTO.RegisterRequest;
import com.example.springtest.DTO.UpdateRequest;
import com.example.springtest.Entity.Account;
import com.example.springtest.Entity.Enum.AccountStatus;
import com.example.springtest.Entity.User;
import com.example.springtest.Entity.UserHistory;
import com.example.springtest.Repository.AccountRepo;
import com.example.springtest.Repository.UserHistoryRepo;
import com.example.springtest.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepo userRepo;
    private final AccountRepo accountRepo;
    private final UserHistoryRepo userHistoryRepo;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepo userRepo, AccountRepo accountRepo, UserHistoryRepo userHistoryRepo, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.accountRepo = accountRepo;
        this.userHistoryRepo = userHistoryRepo;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String Register(RegisterRequest registerRequest) {
        Account account = userRepo.findByNID(registerRequest.getNID()).getAccount();
        if (account != null) {
            return "Account already exists";
        }
        User user = new User();
        user.setNID(registerRequest.getNID());
        user.setName(registerRequest.getName());
        user.setBirthOrEstablishDate(registerRequest.getBirthOrEstablishDate());
        user.setCustomerType(registerRequest.getCustomerType());
        user.setMobileNumber(registerRequest.getMobileNumber());
        user.setPostalCode(registerRequest.getPostalCode());

        account =  new Account();
        account.setAID(AIDGenerator(registerRequest.getNID()));
        account.setUser(user);
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setUsername(registerRequest.getUsername());
        account.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        account.setBalance(0.0);

        user.setAccount(account);

        try {
            userRepo.save(user);
            accountRepo.save(account);
        }catch (Exception e){
            return "Failed to Create Account";
        }

        return "success";
    }

    public String Login(LoginRequest loginRequest) {
        Account account = accountRepo.findByUsername(loginRequest.getUsername());
        if (account == null) {
            return "Account not found";
        }
        if(!account.getPassword().equals(passwordEncoder.encode(loginRequest.getPassword()))){
            return "Wrong Password";
        }

        return jwtService.generateToken(loginRequest.getUsername());
    }

    public String Update(UpdateRequest updateRequest) {
        Account account = userRepo.findByNID(updateRequest.getNID()).getAccount();
        if (account == null) {
            return "No Account Found";
        }

        String AID = account.getAID();
        User user = account.getUser();

        UserHistory userHistory = new UserHistory();
        userHistory.setName(user.getName());
        userHistory.setBirthOrEstablishDate(user.getBirthOrEstablishDate());
        userHistory.setCustomerType(user.getCustomerType());
        userHistory.setMobileNumber(user.getMobileNumber());
        userHistory.setPostalCode(user.getPostalCode());
        userHistory.setAccountStatus(account.getAccountStatus());
        userHistory.setNID(user.getNID());
        userHistory.setAddress(user.getAddress());
        userHistory.setUsername(account.getUsername());
        userHistory.setPassword(account.getPassword());


        user.setNID(updateRequest.getNID());
        user.setName(updateRequest.getName());
        user.setBirthOrEstablishDate(updateRequest.getBirthOrEstablishDate());
        user.setCustomerType(updateRequest.getCustomerType());
        user.setMobileNumber(updateRequest.getMobileNumber());
        user.setPostalCode(updateRequest.getPostalCode());

        account = new Account();
        account.setUser(user);
        account.setAID(AID);
        account.setAccountStatus(updateRequest.getAccountStatus());
        account.setUsername(updateRequest.getUsername());
        account.setPassword(passwordEncoder.encode(updateRequest.getPassword()));

        user.setAccount(account);

        try {
            userHistoryRepo.save(userHistory);
            userRepo.save(user);
            accountRepo.save(account);
        }catch (Exception e){
            return "Failed to Update Account";
        }

        return "success";
    }

    public GetDetailsResponse getDetails(String AID){
        Account account = accountRepo.findByAID(AID);
        if (account == null) {
            return new GetDetailsResponse();
        }
        User user = account.getUser();

        return new GetDetailsResponse(user.getName(), user.getNID(), user.getBirthOrEstablishDate(), user.getCustomerType(), user.getMobileNumber(), user.getAddress(), user.getPostalCode(), account.getAccountStatus());
    }

    public String getAID(String NID){
        User user = userRepo.findByNID(NID);
        if (user == null) {
            return "No Account Found";
        }
        return user.getAccount().getAID();
    }

    private String AIDGenerator(String NID) {
        return NID + "1111";
    }
}
