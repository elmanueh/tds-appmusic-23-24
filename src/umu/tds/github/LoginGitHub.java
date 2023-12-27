package umu.tds.github;

import java.io.IOException;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

/**
 * Clase para verificar el inicio de sesion en GitHub.
 */
public enum LoginGitHub {
	INSTANCE;

	/**
	 * Metodo para verificar un usuario en GitHub.
	 * @param usuario nombre de usuario
	 * @param githubPropertiesPath Path del archivo Properties
	 * @return True / False
	 */
	public boolean verificar(String usuario, String githubPropertiesPath) {
		try {
			GitHub github = GitHubBuilder.fromPropertyFile(githubPropertiesPath).build();
			if (github.isCredentialValid()) {
				GHUser ghuser = github.getMyself();
				return (ghuser.getLogin().equals(usuario) && github.isCredentialValid());
			}
			return false;

		} catch (IOException e) {
				
		} catch (IllegalStateException e) {
			
		}
		return false;
	}

}
