package com.example.elasticsearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserDocumentRepository userDocumentRepository;

    @PostMapping()
    public UserDocument createUser(@RequestBody UserCreateRequestDto userCreateRequestDto) {
        UserDocument user = new UserDocument(
            userCreateRequestDto.getId(),
            userCreateRequestDto.getName(),
            userCreateRequestDto.getAge(),
            userCreateRequestDto.getIsActive()
        );

        return userDocumentRepository.save(user);
    }

    @GetMapping()
    public Page<UserDocument> findUsers() {
        return userDocumentRepository.findAll(PageRequest.of(0, 10));
    }

    @GetMapping("/{id}")
    public UserDocument findUserById(@PathVariable("id") String id) {
        return userDocumentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    
    @PutMapping("/{id}")
    public UserDocument userUpdate(
        @PathVariable("id") String id, 
        @RequestBody UserUpdateRequestDto userUpdateRequestDto
    ){
        UserDocument findUser = userDocumentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        findUser.setName(userUpdateRequestDto.getName());
        findUser.setAge(userUpdateRequestDto.getAge());
        findUser.setIsActive(userUpdateRequestDto.getIsActive());
        return userDocumentRepository.save(findUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        UserDocument findUser = userDocumentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        userDocumentRepository.delete(findUser);
    }
}
