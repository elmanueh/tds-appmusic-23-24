package umu.tds.modelo.musica;

import java.util.Objects;

public class Interprete {
	
	public String interprete;

	public Interprete(String interprete) {
		this.interprete = interprete;
	}

	public String getInterprete() {
		return interprete;
	}

	public void setInterprete(String interprete) {
		this.interprete = interprete;
	}

	@Override
	public int hashCode() {
		return Objects.hash(interprete);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interprete other = (Interprete) obj;
		return Objects.equals(interprete, other.interprete);
	}
}
