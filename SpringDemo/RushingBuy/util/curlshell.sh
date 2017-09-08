function secondKillPost(){
    curl -l -H "Content-Type:application/json" -H "Accept:application/json" -XPOST http://localhost:8080/goods -d '{"name":"car","num":10,"price":10000}'
}
