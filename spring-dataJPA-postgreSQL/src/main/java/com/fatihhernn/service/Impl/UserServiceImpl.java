package com.fatihhernn.service.Impl;

import com.fatihhernn.dto.UserDto;
import com.fatihhernn.entity.Address;
import com.fatihhernn.entity.User;
import com.fatihhernn.repo.AddressRepository;
import com.fatihhernn.repo.UserRepository;
import com.fatihhernn.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {

        Assert.notNull(userDto.getName(),"Name field is necessary");

        User user=new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getName());


        final User userDb=userRepository.save(user);

        List<Address> list=new ArrayList<>();

        userDto.getAddresses().forEach(item->{

            Address address=new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.HOME_ADDRESS);
            address.setActive(true);
            address.setUser(userDb);
            list.add(address);
        });

        addressRepository.saveAll(list);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {

        List<User> users=userRepository.findAll();

        List<UserDto> userDtos=new ArrayList<>();
        users.forEach(it->{
            UserDto userDto=new UserDto();
            userDto.setId(it.getId());
            userDto.setName(it.getName());
            userDto.setSurname(it.getSurname());
            userDto.setAddresses(
                    it.getAddresses() != null ? it.getAddresses().stream().map(Address::getAddress)
                    .collect(Collectors.toList()):null);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
