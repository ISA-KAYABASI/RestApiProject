package com.isakayabasi.taskforecodation;

import com.isakayabasi.taskforecodation.model.User;
import com.isakayabasi.taskforecodation.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskForEcodationApplicationTests implements TestTaskData {

    @Autowired
    UserRepository userRepository;


    @Override
    @Test
    public void testCreate() {
        User user= User.builder().name("isa").lastname("Kayabasi").email("isakayabasi@gmail.com")
                .password("password1").build();
        userRepository.save(user);
        //
        assertNotNull(userRepository.findById(1L).get());
    }


    /////////////////////////////
    //  Failed test with exception
    @Override
    @Test
    public void testCreateFail() {

        User user= User.builder().name("isa").lastname("Kayabasi").email("isakayabasi@gmail.com").password("password1").build();
        userRepository.save(user);

        assertThrows(NullPointerException.class, () -> assertNull(userRepository.findById(1L).get()), "method didnt work out !!!" );

    }
   //////////////////////////////////////



    @Override
    @Test
    public void testList() {
        List<User> userList=userRepository.findAll();
        assertThat(userList).size().isGreaterThan(0);

    }

    @Override
    @Test
    public void testUpdate() {
        User user=userRepository.findById(1L).get();
        user.setName("casablancaa");
        userRepository.save(user);

        assertNotEquals("isa",userRepository.findById(1L).get().getName());

    }

    @Override
    @Test
    public void testDelete() {
        userRepository.deleteById(1L);
        assertThat(userRepository.existsById(1L)).isFalse();

    }


}
