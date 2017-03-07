package savio_estadisticas.clases;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Participants {

@SerializedName("participantes")
@Expose
private List<Participante> participantes = null;

public List<Participante> getParticipantes() {
return participantes;
}

public void setParticipantes(List<Participante> participantes) {
this.participantes = participantes;
}

}