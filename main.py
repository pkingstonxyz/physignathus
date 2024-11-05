import sqlite3
from fastapi import FastAPI
from fastapi.responses import HTMLResponse

app = FastAPI()

@app.get("/items/0")
async def get_item_base():
    """Gets the admin/base user"""
    return {"item_id": "YOWEEEEEEE"}

@app.get("/items/{item_id}")
async def get_item(item_id: int):
    """Allows the user to get an item id"""
    return {"item_id": item_id}

@app.get("/binugs/{bongus}")
async def get_bingus(bongus: FooBarBaz):
    return {"I don't like": "this"}

fake_items_db = [{"item_name": "wingus"},
                 {"item_name": "wungus"},
                 {"item_name": "wongus"}]
@app.get("/items/")
async def get_items(skip: int = 0, limit: int = 10):
    return fake_items_db[skip : skip+limit]
