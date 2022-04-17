package com.soon83.member.interfaces;

import com.soon83.member.application.MemberFacade;
import com.soon83.member.domain.MemberCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/member-api-service/api/v1/members")
public class MemberApiController {

    //private final MemberFacade memberFacade;

    /**
     * 회원 단건 조회
     * @return
     */
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDto.GetResponse> getMember(@PathVariable Long memberId) {
        log.debug("# memberId: {}", memberId);

        return ResponseEntity.ok(MemberDto.GetResponse.builder()
                        .token(UUID.randomUUID().toString())
                        .name("사랑의하츄핑")
                        .email("drogba83@gmail.com")
                .build());
    }

    @PostMapping
    public ResponseEntity<MemberDto.RegisterRequest> saveMember(@RequestBody @Valid MemberDto.RegisterRequest request) {
        // TODO MemberDto.RegisterRequest -> MemberStore
        //MemberCommand command = request.toCommand();

        // TODO save member
        //memberFacade.registerMember(request);

        // TODO MemberInfo -> MemberDto.RegisterResponse
        return null;
    }

}
