package br.com.ebac.memelandia.usuario.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Usuario {


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_usuario")
        //@SequenceGenerator(name = "sequence_usuario", sequenceName = "sequence_usuario", allocationSize = 50)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "nome", nullable = false)
        private String nome;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "data_Cadastro", nullable = false)
        private Date dataCadastro;

        public Usuario() {}

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Date getDataCadastro() {
            return dataCadastro;
        }

        public void setDataCadastro(Date dataCadastro) {
            this.dataCadastro = dataCadastro;
        }


}
