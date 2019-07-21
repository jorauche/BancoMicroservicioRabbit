package beto.banco.notificacion.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Notificacion")
public class NotificacionTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idNotificacion;
	
	private String descripcion;
	private String estatus;
	
}
