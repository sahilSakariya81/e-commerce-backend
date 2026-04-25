package ecommerce_backend.service;
import ecommerce_backend.DTO.LoginDTO;
import ecommerce_backend.DTO.ResponseDTO;
import ecommerce_backend.model.UserTable;
import ecommerce_backend.repository.UserTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserTableRepository userTableRepository;

    @Value("${spring.admin.password}")
    private String adminKey;

    public ResponseDTO register(UserTable ut){

        if("ADMIN".equalsIgnoreCase(ut.getRole())){
            System.out.println("ADMIN KEY: " + adminKey);
            if(!adminKey.equals(ut.getAdminSecret())){
                return new ResponseDTO("Invalid admin secret", HttpStatus.OK);
            }
        }
        else {
            System.out.println("ADMIN KEY: " + adminKey);
            ut.setRole("CUTOMER");
        }

        userTableRepository.save(ut);
        return new ResponseDTO("User Registered Successfully", HttpStatus.OK);
    }

    public ResponseDTO login(LoginDTO ld) {
        UserTable user = userTableRepository.findByEmailAndPassword(ld.getEmail() , ld.getPassword());

        if(user == null){
            return new ResponseDTO("Invalid email or password", HttpStatus.OK);
        }
        return new ResponseDTO("Login successful", HttpStatus.OK);
    }
}
