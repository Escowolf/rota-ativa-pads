import API from './api';

export default class VagaService{

    getVaga(){
        return API.get("/vaga");
    }

    postVaga(vaga){
        return API.post("/vaga", vaga);
    }

}