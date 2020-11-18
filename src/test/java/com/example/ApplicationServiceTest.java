package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

 

import com.cg.rest.OnlineAdmissionSystemApplication;
import com.cg.rest.exception.ResourceNotFoundException;
import com.cg.rest.model.Application;
import com.cg.rest.repository.ApplicationRepository;
import com.cg.rest.service.IApplicationServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineAdmissionSystemApplication.class)
public class ApplicationServiceTest {

    @MockBean
    private ApplicationRepository appliRepo;
    
    @Autowired
    private IApplicationServiceImpl appliServiceImpl;
    
    
    @Test
    public void getApplicationByEmailTest() throws ResourceNotFoundException
    {
        
        String emailId = "sanjay@gmail.com";
        when(appliRepo.findByEmailId(emailId)).thenReturn(Stream.of(new Application(1L,"sanjay",LocalDate.of(1998,8,9),"B.Tech",73.00,"SE","sanjay@gmail.com",
                165,500,5,111,99,"Approved")).collect(Collectors.toList()));
        assertEquals(1, appliServiceImpl.findByEmailId(emailId).size());
    }

 

    @Test
    public void addApplicationTest()
    {
        Application application = new Application(1L,"sanjay",LocalDate.of(1998,8,9),"B.Tech",73.00,"SE","abc@gmail.com",
                165,500,5,111,99,"Approved");
        when(appliRepo.save(application)).thenReturn(application);
        assertEquals(application, appliRepo.save(application));
        
    }
    
}