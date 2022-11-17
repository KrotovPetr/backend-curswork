package com.cursproject.Controller;

//@RestController
//@RequestMapping("api")
//@RequiredArgsConstructor
//public class TestController {
//
//    private final UserService authService;
//
//    @PreAuthorize("hasAuthority('USER')")
//    @GetMapping("hello/user")
//    public ResponseEntity<String> helloUser() {
//        final JwtAuthentication authInfo = authService.getAuthInfo();
//
//        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @GetMapping("hello/admin")
//    public ResponseEntity<String> helloAdmin() {
//        final JwtAuthentication authInfo = authService.getAuthInfo();
//        return ResponseEntity.ok("Hello admin " + authInfo.getPrincipal() + "!");
//    }
//
//}