#! groovy
def NugetPath = ''
def OtherPath = ''

def call(Map config) {
    if ($config.NugetPath != ''){
        NugetPath = $config.NugetPath;
    }

    if ($config.NugetPath != ''){
        OtherPath = $config.OtherPath;
    }   
}
