package com.opipo.terraincognitaserver.rest.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.opipo.terraincognitaserver.dto.Role;
import com.opipo.terraincognitaserver.dto.User;
import com.opipo.terraincognitaserver.service.ServiceDTOInterface;
import com.opipo.terraincognitaserver.service.UserService;

public class UserControllerTest extends AbstractCRUDControllerTest<User, String> {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    private static final String PASSWORD = "4815162342";

    private static final String PASSWORD_ENCODED = "LOST";

    @Override
    AbstractCRUDController<User, String> getController() {
        return userController;
    }

    @Override
    ServiceDTOInterface<User, String> getService() {
        return userService;
    }

    @Override
    String getCorrectID() {
        return "correctId";
    }

    @Override
    String getIncorrectID() {
        return "fakeId";
    }

    @Override
    User buildElement(String id) {
        User user = new User();
        user.setUsername(id);
        user.setPassword(PASSWORD);
        Mockito.when(passwordEncoder.encode(PASSWORD)).thenReturn(PASSWORD_ENCODED);
        return user;
    }

    @Test
    @DisplayName("Try to get all the roles of a user")
    public void givenUserThenGetHisRoles() {
        String userId = getCorrectID();
        List<Role> roles = new ArrayList<>();
        roles.add(new Role());
        User user = Mockito.mock(User.class);
        Mockito.when(user.getRoles()).thenReturn(roles);
        Mockito.when(userService.find(userId)).thenReturn(user);

        ResponseEntity<Collection<Role>> response = userController.getRoles(userId);
        assertEquals("The result isn't the expected", HttpStatus.OK, response.getStatusCode());
        assertTrue("The result isn't the expected", response.getBody().containsAll(roles));
    }

    @Test
    @DisplayName("Try to get one role of a user")
    public void givenUserAndRoleThenReturnRole() {
        String userId = getCorrectID();
        String roleId = "roleId";
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setName(roleId);
        Role role2 = new Role();
        role2.setName("fake");
        Role role3 = new Role();
        role3.setName("false");
        roles.add(role2);
        roles.add(role);
        roles.add(role3);
        User user = Mockito.mock(User.class);
        Mockito.when(user.getRoles()).thenReturn(roles);
        Mockito.when(userService.find(userId)).thenReturn(user);

        ResponseEntity<Role> response = userController.getRole(userId, roleId);
        assertEquals("The result isn't the expected", HttpStatus.OK, response.getStatusCode());
        assertEquals("The result isn't the expected", role, response.getBody());
    }

    @Test
    @DisplayName("Try to add role")
    public void givenUserAndRoleThenAddIt() {
        String userId = getCorrectID();
        String roleId = "roleId";
        User user = Mockito.mock(User.class);
        Mockito.when(userService.addRole(userId, roleId)).thenReturn(user);
        ResponseEntity<User> response = userController.addRole(userId, roleId);
        assertEquals("The result isn't the expected", HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("The result isn't the expected", user, response.getBody());
    }

}
