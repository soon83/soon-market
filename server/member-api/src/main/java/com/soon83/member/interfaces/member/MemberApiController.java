package com.soon83.member.interfaces.member;

import com.soon83.member.application.MemberFacade;
import com.soon83.util.UriGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping("/member-api-service/api/v1/members")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberFacade memberFacade;

    /**
     * 회원 단건 조회
     * @return
     */
    @GetMapping("/{memberToken}")
    public ResponseEntity<MemberDto.GetResponse> retrieveMember(@PathVariable String memberToken, @ModelAttribute MemberDto.RegisterRequest request) {
        var memberInfo = memberFacade.retrieveMember(memberToken);
        var response = new MemberDto.GetResponse(memberInfo);
        return ResponseEntity.ok(response);
    }

    /**
     * 회원 단건 등록
     * @param request
     * @return
     * @throws URISyntaxException
     */
    @PostMapping
    public ResponseEntity<MemberDto.RegisterResponse> registerMember(@RequestBody @Valid MemberDto.RegisterRequest request) throws URISyntaxException {
        var command = request.toCommand();
        var memberInfo = memberFacade.registerMember(command);
        var response = new MemberDto.RegisterResponse(memberInfo);
        return ResponseEntity
                .created(UriGenerator.currentUri(response.getMemberToken()))
                .body(response);
    }
}
