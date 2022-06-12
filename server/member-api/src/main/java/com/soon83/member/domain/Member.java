package com.soon83.member.domain;

import com.soon83.member.common.enumcode.EnumMapper;
import com.soon83.member.common.enumcode.EnumMapperType;
import com.soon83.util.TokenGenerator;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "sm_member")
public class Member {

    private static final String PREFIX_PARTNER = "mbr_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @AllArgsConstructor
    public enum Status implements EnumMapperType {

        ENABLE("활성화"),
        DISABLE("비활성화");

        private final String title;

        private static final Map<String, Status> descriptionMap = Collections.unmodifiableMap(Stream.of(values())
                .collect(Collectors.toMap(Status::getTitle, Function.identity())));

        public static Optional<Status> of(String description) {
            return Optional.ofNullable(descriptionMap.get(description));
        }

        @Override
        public String getCode() {
            return name();
        }

        @Override
        public String getTitle() {
            return title;
        }
    }

    @Builder
    public Member(String name, String email) {
        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
        this.name = name;
        this.email = email;
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }
}
