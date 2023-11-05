package com.example.Chapter6.service.implementasi;

import com.example.Chapter6.model.User;
import com.example.Chapter6.repository.UserRepository;
import com.example.Chapter6.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        // Cari pengguna berdasarkan ID
        User existingUser = userRepository.findById(user.getUserId()).get();

        if (existingUser != null) {
            // Perbarui informasi pengguna
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());

            // Simpan perubahan ke dalam repositori
            return userRepository.save(existingUser);
        } else {
            // Pengguna yang ingin diperbarui tidak ditemukan
            // Anda bisa mengembalikan nilai null atau melakukan yang lain sesuai kebutuhan
            return null;
        }

    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteById(user.getUserId());
    }
}
