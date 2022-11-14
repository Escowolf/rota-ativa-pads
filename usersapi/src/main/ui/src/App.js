import "./reset.css";
import "./base.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Cabecalho } from "./externo/cabecalho/cabecalho";
import { Route, Routes, useLocation } from "react-router-dom";
import { Index } from "./externo/index/index";
import { Rodape } from "./externo/rodape/rodape";
import { Cadastro } from "./externo/cadastro/cadastro";
import { Login } from "./externo/login/login";
import { Map } from "./interno/map/map";
import { Home } from "./interno/home/Home";
import { RelatorioVagas } from "./interno/relatorio_vaga/relatorioVaga";
import { RelatorioUsuario } from "./interno/relatorio_usuarios/relatorioUsuario";
import { DadoUsuario } from "./interno/dados_usuario/dadoUsuario";
import { RelatorioDeUso } from "./interno/relatorio_uso/relatorioDeUso";
import { EditarVaga } from "./interno/adicionar_remover/EditarVaga"
import { RemoverVaga } from "./interno/adicionar_remover/RemoverVaga"

function App() {
  return (
    <>
      {useLocation().pathname == "/" ? <Cabecalho /> : ""}
      <Routes>
        <Route element={<Index />} exact path="/"></Route>
        <Route element={<Cadastro />} exact path="/cadastro"></Route>
        <Route element={<Login />} exact path="/login"></Route>
        <Route element={<Home />} exact path="/menulogado/:id"></Route>
        <Route element={<Map />} exact path="/menulogado/mapa"></Route>
        <Route element={<RelatorioVagas />} exact path="/menulogado/relatorioVagas"></Route>
        <Route element={<RelatorioUsuario />} exact path="/menulogado/relatorioUsuarios/:id"></Route>
        <Route element={<DadoUsuario />} exact path="/menulogado/dadoUsuario/:id"></Route>
        <Route element={<RelatorioDeUso />} exact path="/menulogado/relatorioUso"></Route>
        <Route element={<EditarVaga />} exact path="/editarvaga"></Route>
        <Route element={<RemoverVaga />} exact path="/removervaga"></Route>
      </Routes>
      {useLocation().pathname == "/" ? <Rodape /> : ""}
    </>
  );
}

export default App;
