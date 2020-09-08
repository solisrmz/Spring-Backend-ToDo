/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.todo.Controller;

import com.example.todo.Models.Usuario;
import com.example.todo.clases.TokenUsuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 *
 * @author José A Solís
 */
@RestController
public class UserController {
        @PostMapping("/login")
	public TokenUsuario login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		String token = getJWTToken(username);
		return new TokenUsuario(token, username);
	}

	private String getJWTToken(String username) {
		String secretKey = "todo4964254s5d4654a84sd51a53d4asd1sadssd54as58484wjqirklqncweio88825d48w4dq20xwefwefewfwefcq8gthtyhknf";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
		String token = Jwts
                    .builder()
                    .setId("todo")
                    .setSubject(username)
                    .claim("authorities",
			grantedAuthorities.stream()
			.map(GrantedAuthority::getAuthority)
			.collect(Collectors.toList()))
                        .setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + 960000000))
			.signWith(SignatureAlgorithm.HS512,
			secretKey.getBytes()).compact();
		return token;
	}
}
