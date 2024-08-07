package com.sbs.basic1.boundedContext.member.controller;

import com.sbs.basic1.boundedContext.base.rsData.RsData;
import com.sbs.basic1.boundedContext.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired //생성자를 주입
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping("/member/login")
    @ResponseBody
    public RsData login(String username, String password){
        if(username == null || username.trim().length() == 0 ){
            return RsData.of("F-3","username을 입력해주세요");
        }
        if(password == null || password.trim().length() == 0 ){
            return RsData.of("F-4","password를 입력해주세요");
        }
        return memberService.tryLogin(username,password);
    }

}
