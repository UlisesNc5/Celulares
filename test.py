from datetime import datetime
import json
import pprint
import random
import requests

SERVER_1 = 'http://localhost:8081'
SERVER_1_OPTS = [
    ('GET'   , '/celular/1'),
    ('DELETE', '/celular/2'),
    ('PUT'   , '/celular/3'),
    ('POST'  , '/celular'),

    ('GET', '/list'),
]

SERVER_2 = 'http://localhost:8082'
SERVER_2_OPTS = {
    ('GET', '/list'),
    ('GET', '/celular/1'),
    ('GET', '/store/1/cantidad/5'),
}

def generate_random_number():
    return random.randint(1, 5)

def generate_random_payload():
    possible_names = ['Iphone', 'Samsung', 'Motorola', 'Xiaomi', 'Huawei']
    possible_marcas = [ str(x) for x in range(1, 10) ]
    # created at is now and in json date format
    created_at = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    return {
        'nombre' : possible_names[generate_random_number() % len(possible_names)],
        'marca' : possible_marcas[generate_random_number() % len(possible_marcas)],
    }

def test_server_1():
    print('Testing server 1')
    for (method, path) in SERVER_1_OPTS:
        payload = generate_random_payload()
        print(f'{method}{path} : payload: {payload}')
        response = requests.request(method, SERVER_1 + path, json=payload)
        if response.status_code == 200:
            json = response.json()
            pprint.pprint(json)
        else:
            print(response)

def test_server_2():
    print('Testing server 2')
    for (method, path) in SERVER_2_OPTS:
        print(f'{method}{path}')
        response = requests.request(method, SERVER_2 + path)
        if response.status_code == 200:
            json = response.json()
            pprint.pprint(json)
        else:
            print(response)


test_server_1()
# print('\n')
# test_server_2()

