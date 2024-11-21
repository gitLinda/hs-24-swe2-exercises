package ch.juventus.mocking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    // mock annotation: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#mock_annotation
    @Mock // https://javadoc.io/static/org.mockito/mockito-core/5.14.2/org/mockito/Mock.html
    UserRepository userRepository;

    @Spy // https://javadoc.io/static/org.mockito/mockito-core/5.14.2/org/mockito/Spy.html
    @InjectMocks // https://javadoc.io/static/org.mockito/mockito-core/5.14.2/org/mockito/InjectMocks.html
    UserService userService;

    @Test
    public void testActiveUsersWithEmptyInput() {
        // given
        when(userRepository.getUsers()).thenReturn(new ArrayList<>());

        // when
        List<User> activeUsers = userService.getActiveUsers();

        // then
        assertThat(activeUsers.size()).isEqualTo(0);
        verify(userRepository, times(1)).getUsers();
        // verify basics: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#1
        // verify times: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#4
        // verify never: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#7
        // verify order: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#6
    }

    @Test
    public void testException() {
        // stubbing: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#2
        // stub multiple calls: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#10
        when(userRepository.getUsers()).thenThrow(new UnsupportedOperationException("Users not available"));

        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            userService.getActiveUsers();
        });

        assertEquals("Users not available", exception.getMessage());
    }

    @Test
    public void testFindActiveUserByName() {
        // spy: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#13
        when(userRepository.getUsers()).thenReturn(List.of(new User("linda", 30)));
        doReturn(true).when(userService).isActive(any());
        // argument matcher: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#3

        User user = userService.findActiveUser("linda");

        assertThat(user.getName()).isEqualTo("linda");
        // assertArg: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#55
        verify(userService, times(1)).isActive(assertArg(userArg -> {
            assertThat(userArg.getName()).isEqualTo("linda");
        }));
    }

    @Test
    public void testFindActiveUserByNameWithMultipleUsers() {
        User linda = new User("linda", 30);
        User michael = new User("michael", 30);
        when(userRepository.getUsers()).thenReturn(List.of(linda, michael));
        doReturn(false).when(userService).isActive(linda);
        doReturn(true).when(userService).isActive(michael);

        User user = userService.findActiveUser("linda");
        User user2 = userService.findActiveUser("michael");

        assertThat(user).isNull();
        assertThat(user2).isEqualTo(michael);
    }

    @Test
    public void testGetAdultUsers() {
        User linda = new User("linda", 30);
        User aris = new User("aris", 12);
        List<User> userList = List.of(linda, aris);
        when(userRepository.getUsers()).thenReturn(userList);
        // capture arguments: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#15
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        ArgumentCaptor<Integer> ageCaptor = ArgumentCaptor.forClass(Integer.class);

        List<User> adultUsers = userService.getAdultUsers();

        verify(userService, times(2)).isOlderThan(userCaptor.capture(), ageCaptor.capture());
        assertEquals(userList, userCaptor.getAllValues());
        assertEquals(List.of(18, 18), ageCaptor.getAllValues());
        assertEquals(List.of(linda), adultUsers);
    }

    @Test
    public void testBDDAliases() {
        // aliases for BDD: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#19
        // given
        given(userRepository.getUsers()).willReturn(new ArrayList<>());

        // when
        List<User> activeUsers = userService.getActiveUsers();

        // then
        assertThat(activeUsers.size()).isEqualTo(0);
        then(userRepository).should(times(1)).getUsers();
    }

}