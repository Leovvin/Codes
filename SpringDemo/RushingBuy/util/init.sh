function rushingBuyPost(){
    curl -l -H "Content-Type:application/json" -H "Accept:application/json" -XPOST http://localhost:8080/goods -d '{"name":"car","num":10,"price":10000}'
}
function rushingBuyGet(){
    curl -H "Accept:application/json"  http://localhost:8080/goods/all
}
function rushingBuyPut(){
    curl -l -H "Content-Type:application/json" -H "Accept:application/json" -XPOST http://localhost:8080/goods -d '{"id":3,"name":"car","num":9,"price":10000}'
}
function rushingBuyBookPost(){
    curl -l -H "Content-Type:application/json" -H "Accept:application/json" -XPOST http://localhost:8080/book -d '{"goodid":3}'
}
