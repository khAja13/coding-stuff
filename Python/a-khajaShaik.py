from mega import Mega

mega = Mega()

m = mega.login("khajashaik1000@gmail.com", "khajashaik1000@gmail.com")

details = m.get_user()
print(details)