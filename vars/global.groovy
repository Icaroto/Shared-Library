#! groovy

def nugetPath;

def nuget()
{
    return nugetPath;
} 

def nuget(path) {
    nugetPath = path;
}
