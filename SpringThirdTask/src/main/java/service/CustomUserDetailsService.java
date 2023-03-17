package service;

import repository.UserRepository;
import security.CustomUserDetails;

public class CustomUserDetailsService implements UserDetailsService{

    private UserRepository userRepository;

    @Override
    publicUserDetails loadUserByUserName(String username) throws Username{
        return userRepository.getUserByEmail(username).map(CustomUserDetails::new)
                .orElseThrow() -> new UsernameNotFoundException(String.format())
    }
}
