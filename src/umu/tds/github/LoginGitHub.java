package umu.tds.github;

import java.io.IOException;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

public enum LoginGitHub {
	INSTANCE;

	public boolean verificar(String usuario, String githubPropertiesPath) {
		try {
			GitHub github = GitHubBuilder.fromPropertyFile(githubPropertiesPath).build();
			System.out.println("github.isCredentialValid() ->" + github.isCredentialValid());
			if (github.isCredentialValid()) {
				GHUser ghuser = github.getMyself();
				System.out.println("ghuser.getLogin().equals(usuario) ->" + ghuser.getLogin().equals(usuario));
				System.out.println("github.isCredentialValid() ->" + github.isCredentialValid());
				return (ghuser.getLogin().equals(usuario) && github.isCredentialValid());
			}
			return false;

		} catch (IOException e) {
				
		} catch (IllegalStateException e) {
			
		}
		return false;
	}

}
