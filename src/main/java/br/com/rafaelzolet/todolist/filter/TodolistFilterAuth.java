package br.com.rafaelzolet.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rafaelzolet.todolist.user.ITodolistUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//public class TodolistFilterAuth implements Filter { apresenta apenas servlet request
    //@Override
    //public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    //        throws IOException, ServletException {
    //    chain.doFilter(request, response);
    //}
    @Component // Para o Spring gerenciar
    public class TodolistFilterAuth extends OncePerRequestFilter { // servlet request convertidas

        @Autowired
        private ITodolistUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                var servletPath =  request.getServletPath();

                if(servletPath.startsWith("/task/")){
        
                //Pegar a Autenticação
                var authorization = request.getHeader("Authorization");
                var authoEncoded = authorization.substring("Basic".length()).trim();//extrair e remover espaços
                
                byte[] authoDecode = Base64.getDecoder().decode(authoEncoded); // decodificar
                var authoDecoded = new String(authoDecode);
                String[] credentials = authoDecoded.split(":"); //dividir
                String userName = credentials[0];
                String password = credentials[1];

                //Validar usuario
                var user = this.userRepository.findByUserName(userName);
                if(userName == null){
                    response.sendError(401, "Usuario sem autorização");
                } else {
                    //Validar Senha
                    var passWordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                    if(passWordVerify.verified){
                        request.setAttribute("idUser", user.getId());
                        filterChain.doFilter(request, response);
                    } else {
                        response.sendError(401);
                    }

                }
            } else {
                filterChain.doFilter(request, response);
            }
                
                //condição
    }  
    
    
}
