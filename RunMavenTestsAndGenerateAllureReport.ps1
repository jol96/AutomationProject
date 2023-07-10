# Check if scoop is installed
if (Get-Command scoop -ErrorAction SilentlyContinue) {
    Write-Host "CUSTOM LOGS: Scoop is already installed on this machine"
}
else {
    Write-Host "CUSTOM LOGS: Installing scoop"
    iex "& {$(irm get.scoop.sh)} -RunAsAdmin"
    if ($?) {
        Write-Host "CUSTOM LOGS: Scoop installed successfully!"
    }
    else {
        Write-Host "CUSTOM LOGS: Error installing Scoop"
    }
}

# Check if allure is installed
if (Get-Command allure -ErrorAction SilentlyContinue) {
    Write-Host "CUSTOM LOGS: Allure is already installed on this machine!"
}
else {
    Write-Host "CUSTOM LOGS: Installing Allure"
    scoop install allure
    Write-Host "CUSTOM LOGS: Allure installation complete!"
}

# Check if git is installed
if (Get-Command git -ErrorAction SilentlyContinue) {
    Write-Host "CUSTOM LOGS: Git is already installed on this machine!"
}
else {
    Write-Host "CUSTOM LOGS: Installing git"
    scoop install git
    if ($?) {
        Write-Host "CUSTOM LOGS: Git installed successfully!"
    }
    else {
        Write-Host "CUSTOM LOGS: Error installing Git"
    }
}

# Delete the old allure-results folder
$allureResults = "C:\allure-results"
if (Test-Path -Path $allureResults) {
    Write-Host "CUSTOM LOGS: The folder $allureResults exists. Let's delete it before generating a new report."
    Remove-Item -Path $allureResults -Recurse -Force
    Write-Host "CUSTOM LOGS: Successfully deleted old $allureResults directory."
}

# Delete the old allure-output-report folder
$allureOutputReport = "C:\allure-output-report"
if (Test-Path -Path $allureOutputReport) {
    Remove-Item -Path $allureOutputReport -Recurse -Force
    if ($?) {
        Write-Host "CUSTOM LOGS: Removed old folder: $allureOutputReport successfully!"
    }
    else {
        Write-Host "CUSTOM LOGS: Error removing old folder: $allureOutputReport"
    }
}

# Delete the old cloned repo AutomationProjectResultsReport at C:\AutomationProjectResultsReport
$automationProjectResultsReportRepo = "C:\AutomationProjectResultsReport"
if (Test-Path -Path $automationProjectResultsReportRepo) {
    Remove-Item -Path $automationProjectResultsReportRepo -Recurse -Force
    if ($?) {
        Write-Host "CUSTOM LOGS: Removed old folder: $automationProjectResultsReportRepo successfully!"
    }
    else {
        Write-Host "CUSTOM LOGS: Error removing old folder: $automationProjectResultsReportRepo"
    }
}

# Use Maven to run the pom.xml which contains reference to the XML suite files used to run the tests
Write-Host "CUSTOM LOGS: mvn clean install"
mvn clean install
if ($?) {
    Write-Host "CUSTOM LOGS: Maven completed successfully."
}
else {
    Write-Host "CUSTOM LOGS: Error executing mvn clean test command."
}

# Use Allure to generate the reports
Set-Location "C:\"
ls -Path "C:\"
Write-Host "CUSTOM LOGS: allure generate --output $allureOutputReport $allureResults"
allure generate --output $allureOutputReport $allureResults
if ($?) {
    Write-Host "CUSTOM LOGS: Successfully Generated Allure report."
}
else {
    Write-Host "CUSTOM LOGS: Error generating Allure report."
}

# Clone repository AutomationProjectResultsReport from GitHub
Set-Location "C:\"
$gitCredentials = "https://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@github.com/jol96/AutomationProjectResultsReport.git"

git config --global user.email "jack1996oloughlin@gmail.com"
git config --global user.name "jol96"

Write-Host "CUSTOM LOGS: Cloning Test Results Repo."
git clone $gitCredentials
if ($?) {
    Write-Host "CUSTOM LOGS: Successfully cloned repo."
}
else {
    Write-Host "CUSTOM LOGS: Error cloning repo."
}

# Set the local repository directory
$automationProjectResultsReportRepo = "C:\AutomationProjectResultsReport"
Set-Location $automationProjectResultsReportRepo
if ($?) {
    Write-Host "CUSTOM LOGS: Navigating to $automationProjectResultsReportRepo"
}
else {
    Write-Host "CUSTOM LOGS: Error navigating to $automationProjectResultsReportRepo"
}

# Remove the old allure result test files and folders pulled from the remote repo
Write-Host "CUSTOM LOGS: Remove the old allure result test files and folders pulled from the remote repo"
Remove-Item -Path "$automationProjectResultsReportRepo\data" -Recurse
Remove-Item -Path "$automationProjectResultsReportRepo\export" -Recurse
Remove-Item -Path "$automationProjectResultsReportRepo\history" -Recurse
Remove-Item -Path "$automationProjectResultsReportRepo\plugins" -Recurse
Remove-Item -Path "$automationProjectResultsReportRepo\widgets" -Recurse
Remove-Item -Path "$automationProjectResultsReportRepo\app.js" -Recurse
Remove-Item -Path "$automationProjectResultsReportRepo\favicon.ico" -Recurse
Remove-Item -Path "$automationProjectResultsReportRepo\index.html" -Recurse


# Move the contents of C:\allure-output-report to the git folder C:\AutomationProjectResultsReport
Get-ChildItem -Path $allureOutputReport | Move-Item -Destination $automationProjectResultsReportRepo -Force
if ($?) {
    Write-Host "CUSTOM LOGS: Moved files from $allureOutputReport to $automationProjectResultsReportRepo successfully!"
}
else {
    Write-Host "CUSTOM LOGS: Error moving files from $allureOutputReport to $automationProjectResultsReportRepo"
}

# Add all the files
git config --global core.autocrlf false
git add .
if ($?) {
    Write-Host "CUSTOM LOGS: All files added"
}
else {
    Write-Host "CUSTOM LOGS: Error adding files"
}

# Add and commit your changes
git commit -m "Test results"
if ($?) {
    Write-Host "CUSTOM LOGS: Commited changes"
}
else {
    Write-Host "CUSTOM LOGS: Error committing changes"
}

# Push the changes to the remote repository
git push
if ($?) {
    Write-Host "CUSTOM LOGS: Changes pushed to remote repo successfully"
}
else {
    Write-Host "CUSTOM LOGS: Error pushing changes"
}

Write-Host "CUSTOM LOGS: TEST RESULT REPORT URL - https://salmon-mud-0bf460a03.3.azurestaticapps.net/"
