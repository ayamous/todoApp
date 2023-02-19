# todoApp
authentification + CRUD todo
1)create:
http://localhost:8085/api/v1/todo/
body:
{
    "title" : "todo3",
    "status":"COMPLETED"
}

2)afficher tous les todos
http://localhost:8085/api/v1/todo/all

3)afficher todo by ID
http://localhost:8085/api/v1/todo/1

4)afficher todo by COMPLETED
http://localhost:8085/api/v1/todo/allByCompleted?status=COMPLETED
http://localhost:8085/api/v1/todo/1
5)afficher todo by INCOMPLETED
http://localhost:8085/api/v1/todo/allByInCompleted?status=INCOMPLETED

6)supprimer todo by id
http://localhost:8085/api/v1/todo/1

7)authentification
http://localhost:8085/api/v1/auth/login
body:
{
    "userName": "pardeep161",
    "password": "pardeep@123"
}

