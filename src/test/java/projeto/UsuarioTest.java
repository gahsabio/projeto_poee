package projeto;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.projeto.model.models.Usuario;
import com.projeto.model.service.UsuarioService;

public class UsuarioTest {
	
	@Test
	public void saveUserTest() {
		Usuario usuario = new Usuario();
				
		usuario.setUsername("Gabriel de Freitas Santos Sábio");
		usuario.setPassword("123456");
		usuario.setEmail("gabriefreitas@gmail.com");
		usuario.setAtivo(false);
		usuario.setAdmin(false);
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuarioService.save(usuario);
		
		System.out.println("Gravando usuário no banco de dados");		
	}
	
	@Test
	public void updateUserTest() {
		Usuario usuario = new Usuario();
		
		usuario.setId(1);
		//usuario.setUsername("Gabriel de Freitas Santos Sábio");
		//usuario.setPassword("123456");
		//usuario.setEmail("gabriefreitas@gmail.com");
		//usuario.setAtivo(false);
		//usuario.setAdmin(false);
		
		UsuarioService usuarioService = new UsuarioService();
		
		usuario = usuarioService.findById(usuario.getId());
		
		usuario.setEmail("gahsabio@outlook.com");
		
		System.out.println(usuario.toString());
		
		usuarioService.update(usuario);
		
		//System.out.println("Alterando usuário no banco de dados");		
	}

}
