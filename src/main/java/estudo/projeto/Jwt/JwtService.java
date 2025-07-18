package estudo.projeto.Jwt;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;

import estudo.projeto.usuario.Usuario;

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
        try {
            return JWT.require(algorithm)
                    .withIssuer(Emissor)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTDecodeException e) {
            throw new JWTDecodeException("Erro");
        }
    }

    private Instant creationDate() {
        return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant();
    }

    private Instant expirationDate() {
        return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).plusHours(4).toInstant();
    }

}
