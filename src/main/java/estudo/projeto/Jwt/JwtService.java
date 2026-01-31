package estudo.projeto.Jwt;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.auth0.jwt.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import estudo.projeto.Entity.Usuario;
import org.springframework.web.server.ResponseStatusException;

@Service
public class JwtService {

    private final String Emissor = "est-api";
    private final Algorithm algorithm = Algorithm.HMAC256("00912323445DD#$11S8999F");

    public String generateToken(Usuario usuario) {
        try {
            return JWT.create()
                    .withIssuer(Emissor)
                    .withIssuedAt(creationDate())
                    .withExpiresAt(expirationDate())
                    .withSubject(usuario.getName())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new JWTCreationException("Erro ao gerar token.", e);
        }
    }

    public String verifyToken(String token) {
        return JWT.require(algorithm)
                .withIssuer(Emissor)
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant creationDate() {
        return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant();
    }

    private Instant expirationDate() {
        return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).plusHours(4).toInstant();
    }

}
