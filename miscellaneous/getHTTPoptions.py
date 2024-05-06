import http.client as client, socket

try:
    conn = client.HTTPConnection('www.google.com', 80)
    conn.request('OPTIONS', '/')
    resp = conn.getresponse()
    options = resp.getheader('allowed')
    print(f'Enabled methods are: {options}')
    conn.close()

except ConnectionRefusedError:
    print("Failed to connect!")





