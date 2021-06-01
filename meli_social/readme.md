## Endpoints
----
Comprador poder seguir um vendedor
Request:
[POST] "{idBuyer}/follow;"
    body{
        "idSeller": "UUID4",
    }
response:
sucess -> [201]
fail -> [400]

----
Quantidade,Usuarios  que seguem vendedor
request:
[GET] "{idSeller}/followers/?List=False;"
response:
[200] {"numberOfFollowers": int }

---
Usuarios  que seguem vendedor
request:
[GET] "{idSeller}/followers/?List=True;order={alphabASC|alphabDESC|dateASC|dateDESC};"
response:
[200] {
    "qtdOfFollowers": int,
    "listOfFollowers": [buyers],
    }

---
Quem um usuario esta seguindo
request:
[GET] "{idBuyer}/following?order={alphabASC|alphabDESC|dateASC|dateDESC};"
reponse:
[200]{
    "qtdOfFollowing": int, 
    "listOfFollowing": [sellers],
    }

---
Registrar uma nova publicação
request:
[POST] "{idSeller}/post"
body{
    "publication" : String
}
response:
sucess -> [201]
fail -> [400]

---
Posts que o usuario(buyer) segue de acordo com um periodo
[GET]"{idSeller}/posts/?dtInit={Date};dtEnd={Date};order={alphabASC|alphabDESC|dateASC|dateDESC};"
reponse:
sucess-> [200]
    {
        "posts" : [posts],
    }
fail-> [400]

---
Unfollow
request:
[POST]"{idBuyer}/following/unfollow/"
body{
    "idSeller": UUID
}
response:
[200]

---
Promote
request:
[POST]"/{idBuyer}/{postId}/promote"
body{
    "dateInit" : Date,
    "dateFinish": Date,
    "discont"; double(percent),
}
response:
[201]