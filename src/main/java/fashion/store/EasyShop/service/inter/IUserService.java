package fashion.store.EasyShop.service.inter;

import fashion.store.EasyShop.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    UserDto getUser(Long id);

    UserDto getUserByEmail(String email);

    List<UserDto> getUsers();

    UserDto createUser(UserDto newUser);

    UserDto updateUser(UserDto user, Long id);

    UserDto getLoggedInUser();

    void deleteUser(Long id);
}
