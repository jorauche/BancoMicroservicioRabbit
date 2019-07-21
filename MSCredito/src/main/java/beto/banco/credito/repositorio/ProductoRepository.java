package beto.banco.credito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import beto.banco.credito.entity.ProductoTO;

public interface ProductoRepository extends JpaRepository<ProductoTO, Integer>{

	
	@Query("SELECT p FROM ProductoTO p WHERE p.claveUsuario = ?1")
	List<ProductoTO> productosUsuario(int claveUsuario);
}
