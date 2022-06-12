package com.soon83.member.interfaces.member;

import com.soon83.member.common.enumcode.EnumMapper;
import com.soon83.member.common.enumcode.EnumMapperValue;
import com.soon83.member.common.response.CommonResponse;
import com.soon83.util.UriGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/member-api-service/api/v1/member-codes")
@RequiredArgsConstructor
public class MemberCodeApiController {

    private final EnumMapper enumMapper;

    /**
     * 회원코드 목록 조회
     * @return
     */
    @GetMapping
    public ResponseEntity<CommonResponse> retrieveMemberCodes() {
        var response = enumMapper.getAll();

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.success(response));
    }

    /**
     * 회원코드 단건 조회
     * @return
     */
    @GetMapping("/{codeName}")
    public ResponseEntity<CommonResponse> retrieveMemberCode(@PathVariable String codeName, @ModelAttribute MemberDto.RegisterRequest request) {
        var response = enumMapper.get(codeName);

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.success(response));
    }
}
