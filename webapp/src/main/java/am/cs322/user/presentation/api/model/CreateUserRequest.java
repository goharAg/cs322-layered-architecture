package am.cs322.user.presentation.api.model;

import jakarta.annotation.Nonnull;

public record CreateUserRequest(@Nonnull
                                String firstName,
                                @Nonnull
                                String lastName) {
}
