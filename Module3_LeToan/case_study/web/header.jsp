<div class="col-12 row bg-info m-0 fixed-top" style="height: 100px">
    <div class="col-2 p-0">
        <img src="image/codegym.png" class="img-thumbnail" alt="logo" height="100" width="100">
    </div>
    <h2 style="margin-top: 30px">FURAMA RESORT</h2>
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top col-12" style="top: 100px">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link text-success" href="home.jsp"><span class="fas fa-home"></span> Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-success" href="/employee"><span class="fas fa-people-arrows"></span>
                    Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-success" href="/customer"><span class="fas fa-user"></span> Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-success" href="/service"><span class="fas fa-list"></span> Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-success" href="/contract"><span class="fas fa-file-contract"></span>
                    Contract</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" value="${search}"
                   name="search">
            <input type="hidden" name="action" value="search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>


