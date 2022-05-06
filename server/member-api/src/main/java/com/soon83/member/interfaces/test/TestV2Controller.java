
package com.soon83.member.interfaces.test;

import com.soon83.member.domain.MemberService;
import com.soon83.member.interfaces.member.MemberDto;
import com.soon83.member.interfaces.test.dto.*;
import com.soon83.util.UriGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping("/test-api-service/api/v1/tests")
@RequiredArgsConstructor
public class TestV2Controller {

    private final MemberService memberService;


/**
     * Test 목록 조회
     * @return
     */

    @GetMapping
    public ResponseEntity<MemberDto.GetResponse> getMembers(
            @PathVariable String testId, @Valid TestSelectDto request) {

        var memberInfo = memberService.retrieveMember(testId);
        var response = new MemberDto.GetResponse(memberInfo);
        return ResponseEntity.ok(response);
    }


/**
     * Test 단건 등록
     * @param request
     * @return
     * @throws URISyntaxException
     */

    @PostMapping
    public ResponseEntity<MemberDto.RegisterResponse> createMember(
            @RequestBody @Valid TestCreateDto request) throws URISyntaxException {

        var memberInfo = memberService.registerMember(request);
        var response = memberInfo;
        return ResponseEntity
                .created(UriGenerator.currentUri(memberInfo))
                .body(response);
    }


/**
     * Test 단건 조회
     * @return
     */

    @GetMapping("/{testId}")
    public ResponseEntity<MemberDto.GetResponse> getMember(
            @PathVariable String testId, @Valid TestSelectDto request) {

        var memberInfo = memberService.retrieveMember(request);
        var response = new MemberDto.GetResponse(memberInfo);
        return ResponseEntity.ok(response);
    }


/**
     * Test 단건 수정 (All)
     * @param request
     * @return
     * @throws URISyntaxException
     */

    @PutMapping
    public ResponseEntity<MemberDto.RegisterResponse> updateAll(
            @RequestBody @Valid TestUpdateAllDto request) throws URISyntaxException {

        var memberInfo = memberService.registerMember(request);
        var response = memberInfo;
        return ResponseEntity.ok(response);
    }


/**
     * Test 단건 수정 (user address patch)
     * @param request
     * @return
     * @throws URISyntaxException
     */

    @PatchMapping
    public ResponseEntity<MemberDto.RegisterResponse> updateOnlyAddress(
            @RequestBody @Valid TestUpdateOnlyAddressDto request) throws URISyntaxException {

        var memberInfo = memberService.registerMember(request);
        var response = memberInfo;
        return ResponseEntity.ok(response);
    }


/**
     * Test 단건 수정 (user phone patch)
     * @param request
     * @return
     * @throws URISyntaxException
     */

    @PatchMapping
    public ResponseEntity<MemberDto.RegisterResponse> updateOnlyPhone(
            @RequestBody @Valid TestUpdateOnlyPhoneDto request) throws URISyntaxException {

        var memberInfo = memberService.registerMember(request);
        var response = memberInfo;
        return ResponseEntity.ok(response);
    }
}

