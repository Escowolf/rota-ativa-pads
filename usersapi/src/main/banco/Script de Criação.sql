-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema RotaAtiva
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema RotaAtiva
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `RotaAtiva` DEFAULT CHARACTER SET utf8 ;
USE `RotaAtiva` ;

-- -----------------------------------------------------
-- Table `RotaAtiva`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`usuario` (
  `idusuario` INT NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `acessibilidade` TINYINT(1) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `datanasc` DATE NOT NULL,
  `ticket` INT NULL,
  `estadoUsuario` TINYINT(1) NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RotaAtiva`.`tipoVaga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`tipoVaga` (
  `idtipoVaga` INT NOT NULL,
  `tipoVaga` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipoVaga`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RotaAtiva`.`tempoTicket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`tempoTicket` (
  `idtempoTicket` INT NOT NULL,
  `tempoTicket` INT NOT NULL,
  PRIMARY KEY (`idtempoTicket`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RotaAtiva`.`vaga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`vaga` (
  `idvaga` INT NOT NULL AUTO_INCREMENT,
  `rua_avenida` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NULL,
  `acessibilidade` TINYINT(1) NOT NULL,
  `nomeVaga` VARCHAR(45) NOT NULL,
  `longitudeInicial` VARCHAR(45) NOT NULL,
  `longitudeFinal` VARCHAR(45) NOT NULL,
  `latitudeInicial` VARCHAR(45) NOT NULL,
  `latitudeFinal` VARCHAR(45) NOT NULL,
  `tempoTicket_idtempoTicket` INT NOT NULL,
  `tipoVaga_idtipoVaga` INT NOT NULL,
  `horarioUsoInica` TIME NOT NULL,
  `horarioUsoFinal` TIME NOT NULL,
  `estadoVaga` TINYINT(1) NULL,
  `quantidadeVaga` INT NULL,
  PRIMARY KEY (`idvaga`, `tempoTicket_idtempoTicket`, `tipoVaga_idtipoVaga`),
  INDEX `fk_vaga_tipoVaga1_idx` (`tipoVaga_idtipoVaga` ASC) VISIBLE,
  INDEX `fk_vaga_tempoTicket1_idx` (`tempoTicket_idtempoTicket` ASC) VISIBLE,
  CONSTRAINT `fk_vaga_tipoVaga1`
    FOREIGN KEY (`tipoVaga_idtipoVaga`)
    REFERENCES `RotaAtiva`.`tipoVaga` (`idtipoVaga`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vaga_tempoTicket1`
    FOREIGN KEY (`tempoTicket_idtempoTicket`)
    REFERENCES `RotaAtiva`.`tempoTicket` (`idtempoTicket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RotaAtiva`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`telefone` (
  `idtelefone` INT NOT NULL,
  `usuario_idusuario` INT NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtelefone`, `usuario_idusuario`),
  INDEX `fk_telefone_usuario_idx` (`usuario_idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_telefone_usuario`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `RotaAtiva`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RotaAtiva`.`veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`veiculo` (
  `idveiculo` INT NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idveiculo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RotaAtiva`.`pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`pagamento` (
  `idpagamento` INT NOT NULL,
  `dataCompra` DATETIME NOT NULL,
  `valor` DOUBLE NOT NULL,
  `quantidadeTicket` INT NOT NULL,
  `usuario_idusuario` INT NOT NULL,
  PRIMARY KEY (`idpagamento`, `usuario_idusuario`),
  INDEX `fk_pagamento_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_pagamento_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `RotaAtiva`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RotaAtiva`.`tipopagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`tipopagamento` (
  `idTipoPagamento` INT NOT NULL,
  `TipoPagamento` VARCHAR(45) NOT NULL,
  `DescPagamento` VARCHAR(45) NOT NULL,
  `pagamento_idpagamento` INT NOT NULL,
  `pagamento_usuario_idusuario` INT NOT NULL,
  PRIMARY KEY (`idTipoPagamento`, `pagamento_idpagamento`, `pagamento_usuario_idusuario`),
  INDEX `fk_tipopagamento_pagamento1_idx` (`pagamento_idpagamento` ASC, `pagamento_usuario_idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_tipopagamento_pagamento1`
    FOREIGN KEY (`pagamento_idpagamento` , `pagamento_usuario_idusuario`)
    REFERENCES `RotaAtiva`.`pagamento` (`idpagamento` , `usuario_idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RotaAtiva`.`usuario_has_veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`usuario_has_veiculo` (
  `usuario_idusuario` INT NOT NULL,
  `veiculo_idveiculo` INT NOT NULL,
  PRIMARY KEY (`usuario_idusuario`, `veiculo_idveiculo`),
  INDEX `fk_usuario_has_veiculo_veiculo1_idx` (`veiculo_idveiculo` ASC) VISIBLE,
  INDEX `fk_usuario_has_veiculo_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_has_veiculo_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `RotaAtiva`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_veiculo_veiculo1`
    FOREIGN KEY (`veiculo_idveiculo`)
    REFERENCES `RotaAtiva`.`veiculo` (`idveiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RotaAtiva`.`transacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`transacao` (
  `idtransacao` INT NOT NULL,
  `vaga_idvaga` INT NOT NULL,
  `usuario_idusuario` INT NOT NULL,
  `entrada` DATETIME NOT NULL,
  `saida` DATETIME NOT NULL,
  `ticketsUsados` INT NOT NULL,
  PRIMARY KEY (`idtransacao`, `vaga_idvaga`, `usuario_idusuario`),
  INDEX `fk_transacao_vaga1_idx` (`vaga_idvaga` ASC) VISIBLE,
  INDEX `fk_transacao_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_transacao_vaga1`
    FOREIGN KEY (`vaga_idvaga`)
    REFERENCES `RotaAtiva`.`vaga` (`idvaga`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transacao_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `RotaAtiva`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `RotaAtiva`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `RotaAtiva`.`administrador` (
  `idadministrador` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `datanasc` DATE NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idadministrador`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
