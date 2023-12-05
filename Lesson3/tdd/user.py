class User:
    def __init__(self, name, password, isAdmin):
        self.name = name
        self.password = password
        self.isAdmin = isAdmin
        self.isAuthenticate = False

    # 3.6.
    def authenticate(self, name, password):
        return False
