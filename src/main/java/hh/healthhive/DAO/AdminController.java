package hh.healthhive.DAO;
import java.util.List;

import hh.healthhive.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private TokenServiceImpl tokenService;

    GenerateToken generateToken = new GenerateToken();

    @PostMapping("/saveAdmin")
    public int saveAdminDetail(@RequestBody User adminDetail) {
        return adminService.saveAdminDetail(adminDetail);
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody User adminDetail)
    {
        System.out.println("IN ADMIN CONTROLLER" + adminDetail);
        int status;
        HttpHeaders httpHeader = null;
        // Authenticate User.
        status = adminService.adminLogin(adminDetail.getEmail(), adminDetail.getPassword());
        /*
         * If User is authenticated then Do Authorization Task.
         */
        if (status > 0)
        {
            /*
             * Generate token.
             */
            String tokenData[] = generateToken.createJWT(adminDetail.getEmail(), "JavaTpoint", "JWT Token",
                    adminDetail.getRole(), 43200000);
            // get Token.
            String token = tokenData[0];
            System.out.println("Authorization: Bearer " + token);

            // Create the Header Object
            httpHeader = new HttpHeaders();

            // Add token to the Header.
            httpHeader.add("Authorization", token);

            // Check if token is already exist.
            long isUserEmailExists = tokenService.getTokenDetail(adminDetail.getEmail());
            /*
             * If token exist then update Token else create and insert the token.
             */
            if (isUserEmailExists > 0)
            {
                tokenService.updateToken(adminDetail.getEmail(), token, tokenData[1]);
            }
            else
            {
                tokenService.saveUserEmail(adminDetail.getEmail(), status);
                tokenService.updateToken(adminDetail.getEmail(), token, tokenData[1]);
            }

            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);
        }

        // if not authenticated return  status what we get.
        else
        {
            return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);
        }


    }


    @GetMapping("/getAdminData/{adminId}")
    public List<User> getAdminData(@PathVariable int adminId, @RequestHeader("Authorization") String authorizationToken)
    {
        String token[] = authorizationToken.split(" ");
        int result = tokenService.tokenAuthentication(token[1], adminId);

        if (result > 0) {
            return adminService.getAdminData();
        } else {
            return null;
        }
    }


}
