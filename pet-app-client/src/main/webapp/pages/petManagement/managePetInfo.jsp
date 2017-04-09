<%-- 
    Document   : managePetInfo
    Created on : Mar 8, 2017, 8:15:42 AM
    Author     : admin
--%>

<!--<table class="table">
    <thead>
        <tr>
            <th>S.N</th>
            <th>Image</th>
            <th>Name</th>
            <th>Owner Name</th>
            <th>Contact No</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="petInfo in petInfos">
            <td>{{$index+1}}</td>
            <td><img ng-src="data:image/;base64,{{petInfo.imagePath}}" style="width: 50px;height: 50px"></td>
            <td>{{petInfo.name}}</td>
            <td>{{petInfo.ownerName}}</td>
            <td>{{petInfo.ownerNo}}</td>
            <td></td>
        </tr>
    </tbody>
</table>-->
<div>
    <span>total Pets {{petCounts}}</span>
</div>
<div>
    <input type="text" ng-bind="message"/>
    <button ng-click="webSocketTest()">Message</button>
</div>
<div>
    <div ng-show="errorMessage.lenght !== 0"><span style="color: red">{{errorMessage}}</span></div>
    <table ng-table="tableParams" class="table table-condensed table-bordered table-striped">
        <tr ng-repeat="row in $data">
            <td data-title="'S.N'">{{$index + 1}}</td>
            <td data-title="'Image'"><img ng-src="data:image/;base64,{{row.imagePath}}" style="width: 50px;height: 50px"></td>
            <td data-title="'Name'" filter="{name: 'text'}" sortable="'name'">{{row.name}}</td>
            <td data-title="'Owner Name'">{{row.ownerName}}</td>
            <td data-title="'Owner No'" filter="{ownerNo: 'text'}" sortable="'ownerNo'">{{row.ownerNo}}</td>
            <td data-title="'Action'">
                <a ng-click="editPetInfo(row)">Edit</a>
                <a ng-click="deletePetInfo(row)">Delete</a>
            </td>
        </tr>
    </table>
</div>