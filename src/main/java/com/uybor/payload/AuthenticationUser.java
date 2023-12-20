package com.uybor.payload;

import com.uybor.entity.User;

public record AuthenticationUser(
        String token,
        User user
) {
}
