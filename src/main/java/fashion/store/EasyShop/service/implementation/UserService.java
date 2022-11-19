package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.dto.UserDto;
import fashion.store.EasyShop.service.inter.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserService implements IUserService {
    @Override
    public UserDto getUser(Long id) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> getUsers() {
        return null;
    }

    @Override
    public UserDto createUser(UserDto newUser) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user, Long id) {
        return null;
    }

    @Override
    public UserDto getLoggedInUser() {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
