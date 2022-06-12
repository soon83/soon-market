package com.soon83.member.interfaces.member;

import com.soon83.member.application.MemberFacade;
import com.soon83.member.common.response.CommonResponse;
import com.soon83.util.UriGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/member-api-service/api/v1/members")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberFacade memberFacade;

    /**
     * 회원 목록 조회
     * @return
     */
    @GetMapping
    public ResponseEntity<CommonResponse> retrieveMembers() {
        var memberInfoList = memberFacade.retrieveMembers();
        var response = memberInfoList.stream()
                .map(MemberDto.GetResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.success(response));
    }

    /**
     * 회원 단건 조회
     * @return
     */
    @GetMapping("/{memberToken}")
    public ResponseEntity<CommonResponse> retrieveMember(@PathVariable String memberToken, @ModelAttribute MemberDto.RegisterRequest request) {
        var memberInfo = memberFacade.retrieveMember(memberToken);
        var response = new MemberDto.GetResponse(memberInfo);

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.success(response));
    }

    /**
     * 회원 단건 등록
     * @param request
     * @return
     * @throws URISyntaxException
     */
    @PostMapping
    public ResponseEntity<CommonResponse> registerMember(@RequestBody @Valid MemberDto.RegisterRequest request) throws URISyntaxException {
        var command = request.toCommand();
        var memberInfo = memberFacade.registerMember(command);
        var response = new MemberDto.RegisterResponse(memberInfo);

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(UriGenerator.currentUri(response.getMemberToken()))
                .body(CommonResponse.success(response));
    }
}
